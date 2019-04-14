package com.example.jpademo.controller;

import com.example.jpademo.domain.TestDO;
import com.example.jpademo.domain.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class HelloWorldController {

    @Autowired
    private TestDao testDao;

    @GetMapping("/{id}")
    public TestDO get(@PathVariable long id) {
        return testDao.findById(id).orElse(new TestDO());
    }

    @PostMapping
    public TestDO post (@RequestParam() TestDO testDO){
        return testDao.save(testDO);
    }

    @PutMapping
    public TestDO put (@RequestParam() TestDO testDO){
        return testDao.save(testDO);
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable long id) {
        testDao.deleteById(id);
        return "success";
    }

}