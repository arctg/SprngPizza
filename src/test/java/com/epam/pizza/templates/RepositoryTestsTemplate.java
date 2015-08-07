package com.epam.pizza.templates;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by dennis on 8/5/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/repositoryContext.xml")
@TransactionConfiguration
//@FixMethodOrder(MethodSorters.JVM)
public class RepositoryTestsTemplate extends AbstractTransactionalJUnit4SpringContextTests{

}
