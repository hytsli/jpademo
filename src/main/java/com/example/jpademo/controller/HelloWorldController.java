package com.example.jpademo.controller;

import com.example.jpademo.domain.TestDO;
import com.example.jpademo.domain.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/test")
@RestController
public class HelloWorldController {

    @Autowired
    private TestDao testDao;

    @GetMapping("/{id}")
    public TestDO get(@PathVariable long id) {
        return testDao.findById(id).orElse(TestDO.builder().name("AAA").description("test").build());
    }

    @GetMapping("/byName/{name}")
    public TestDO get(@PathVariable String name) {
        return testDao.findByName(name).orElse(TestDO.builder().name("AAA").description("test").build());
    }

    @GetMapping("/byDes/{des}")
    public List<TestDO> getByDes(@PathVariable String des) {
        return testDao.findByDescription(des);
    }

    @GetMapping("/pageByDes/{des}")
    public Page<TestDO> getPageByDes(@PathVariable String des, @RequestParam int size, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.Direction.DESC, "id");
        return testDao.findPageByDescription(des,pageable);
    }


    @GetMapping("/pageByDesInSql/{des}")
    public Page<TestDO> getPageByDesInSql(@PathVariable String des, @RequestParam int size, @RequestParam int pageNum) {
        Pageable pageable = PageRequest.of(pageNum, size, Sort.Direction.DESC, "id");
        return testDao.findPageByDescriptionInSql(des,pageable);
    }

    @PostMapping
    public TestDO post (@RequestBody() TestDO testDO){
        return testDao.save(testDO);
    }

    @PutMapping
    public TestDO put (@RequestBody() TestDO testDO){
        return testDao.save(testDO);
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable long id) {
        testDao.deleteById(id);
        return "success";
    }

}