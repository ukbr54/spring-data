package com.example.persistenceproject.service;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollegeManagementService {

    private @Autowired GuideRepository guideRepository;

    @Transactional
    public void persistingGuides(){
        Guide guide1 = new Guide("2024FEB1988","Mike Lawson",1000);
        Guide guide2 = new Guide("2024MAR0098","Ian Lamb",2000);

        guideRepository.save(guide1);
        guideRepository.save(guide2);
    }

    /* Automatic dirty checking in case of READ_WRITE
       So in this case the snapshot of the object is loaded and during flushing process it will compare
       the object and do dirty checking
     */
    @Transactional
    public void fetchingReadWriteGuide(){
        Guide guide = guideRepository.findById(1L).get();
        guide.setSalary(2500);
    }

    @Transactional(readOnly = true)
    public void fetchingReadOnlyGuide(){
        Guide guide = guideRepository.findById(1L).get();
        guide.setSalary(2500);
    }

    @Transactional(readOnly = true)
    public Guide findGuideById(Long id){
        return guideRepository.findById(id).get();
    }

    @Transactional
    public void updateGuide(Guide guide){
        guideRepository.save(guide);
    }

    @Transactional
    public void prepareNameAndSalaryReportOfAllGuides() {

        //select guide.name, guide.salary from Guide guide
        List<Object[]> resultList = guideRepository.getNameAndSalaryOfAll();
        for (Object[] object : resultList) {
            System.out.println("Name: " + object[0] + "\t\t Salary: " + object[1]);
        }

        //select sum(guide.salary) from Guide guide
        System.out.println("The total salary of all the guides is " + guideRepository.calculateSumOfAllSalaries());

        //update Guide guide set guide.salary = guide.salary * 2
//        System.out.println( guideRepository.doubleSalaryOfAll() );

    }

    @Transactional
    public void raiseSalaryOfGuide(Long id, Integer newSalary) {

        Guide guide = guideRepository.findById( id ).get();
        guide.setSalary(newSalary);

    }

}
