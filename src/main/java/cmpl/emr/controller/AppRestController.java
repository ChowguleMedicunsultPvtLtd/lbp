/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpl.emr.controller;

import cmpl.emr.model.Districts;
import cmpl.emr.model.Locate;
import cmpl.emr.model.States;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
@ComponentScan(basePackages = "cmpl.emr.*")
public class AppRestController {
    
    @Autowired
    private SessionFactory sessionFactory;
    
 
    @Transactional
    @RequestMapping(value = {"/Tehsil"}, method = RequestMethod.GET)
    public @ResponseBody List<Locate> Taluka() {
        return sessionFactory.openSession().createQuery("from Locate").list();
        
//        Query query = sessionFactory.openSession().createQuery("from Locate");
//        query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//        return query.list();
        
    }
    
    @Transactional
    @RequestMapping(value = {"/District"}, method = RequestMethod.GET)
    public @ResponseBody List<Districts> District() {
        return sessionFactory.openSession().createQuery("from Districts").list();

    }
    
     @Transactional
    @RequestMapping(value = {"/State"}, method = RequestMethod.GET)
    public @ResponseBody List<States> State() {
        return sessionFactory.openSession().createQuery("from States").list();

    }
    
}
