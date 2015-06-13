/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.Date;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SIDIBE Der (dersidibe@gmail.com)
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdAccount method, of class Account.
     */
    @Test
    public void testGetIdAccount() {
        System.out.println("getIdAccount");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getIdAccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdAccount method, of class Account.
     */
    @Test
    public void testSetIdAccount() {
        System.out.println("setIdAccount");
        int idAccount = 0;
        Account instance = new Account();
        instance.setIdAccount(idAccount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Account.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Account.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Account instance = new Account();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Account.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Account.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Account instance = new Account();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Account.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Account instance = new Account();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Account instance = new Account();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Account.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Account.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        String image = "";
        Account instance = new Account();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Account.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Account instance = new Account();
        short expResult = 0;
        short result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Account.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        short type = 0;
        Account instance = new Account();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPromotion method, of class Account.
     */
    @Test
    public void testGetPromotion() {
        System.out.println("getPromotion");
        Account instance = new Account();
        Integer expResult = null;
        Integer result = instance.getPromotion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPromotion method, of class Account.
     */
    @Test
    public void testSetPromotion() {
        System.out.println("setPromotion");
        Integer promotion = null;
        Account instance = new Account();
        instance.setPromotion(promotion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Account.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Account instance = new Account();
        short expResult = 0;
        short result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Account.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        short status = 0;
        Account instance = new Account();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Account.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Account.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Account instance = new Account();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthday method, of class Account.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getBirthday();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthday method, of class Account.
     */
    @Test
    public void testSetBirthday() {
        System.out.println("setBirthday");
        Date birthday = null;
        Account instance = new Account();
        instance.setBirthday(birthday);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNationality method, of class Account.
     */
    @Test
    public void testGetNationality() {
        System.out.println("getNationality");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getNationality();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNationality method, of class Account.
     */
    @Test
    public void testSetNationality() {
        System.out.println("setNationality");
        String nationality = "";
        Account instance = new Account();
        instance.setNationality(nationality);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSex method, of class Account.
     */
    @Test
    public void testGetSex() {
        System.out.println("getSex");
        Account instance = new Account();
        char expResult = ' ';
        char result = instance.getSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSex method, of class Account.
     */
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        char sex = ' ';
        Account instance = new Account();
        instance.setSex(sex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupation method, of class Account.
     */
    @Test
    public void testGetOccupation() {
        System.out.println("getOccupation");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getOccupation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOccupation method, of class Account.
     */
    @Test
    public void testSetOccupation() {
        System.out.println("setOccupation");
        String occupation = "";
        Account instance = new Account();
        instance.setOccupation(occupation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreatedDate method, of class Account.
     */
    @Test
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreatedDate method, of class Account.
     */
    @Test
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        Date createdDate = null;
        Account instance = new Account();
        instance.setCreatedDate(createdDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModifiedDate method, of class Account.
     */
    @Test
    public void testGetModifiedDate() {
        System.out.println("getModifiedDate");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getModifiedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModifiedDate method, of class Account.
     */
    @Test
    public void testSetModifiedDate() {
        System.out.println("setModifiedDate");
        Date modifiedDate = null;
        Account instance = new Account();
        instance.setModifiedDate(modifiedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobStartTime method, of class Account.
     */
    @Test
    public void testGetJobStartTime() {
        System.out.println("getJobStartTime");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getJobStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJobStartTime method, of class Account.
     */
    @Test
    public void testSetJobStartTime() {
        System.out.println("setJobStartTime");
        Date jobStartTime = null;
        Account instance = new Account();
        instance.setJobStartTime(jobStartTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJobEndTime method, of class Account.
     */
    @Test
    public void testGetJobEndTime() {
        System.out.println("getJobEndTime");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getJobEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJobEndTime method, of class Account.
     */
    @Test
    public void testSetJobEndTime() {
        System.out.println("setJobEndTime");
        Date jobEndTime = null;
        Account instance = new Account();
        instance.setJobEndTime(jobEndTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvents method, of class Account.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvents method, of class Account.
     */
    @Test
    public void testSetEvents() {
        System.out.println("setEvents");
        Set events = null;
        Account instance = new Account();
        instance.setEvents(events);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessagesForAccountId2 method, of class Account.
     */
    @Test
    public void testGetMessagesForAccountId2() {
        System.out.println("getMessagesForAccountId2");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getMessagesForAccountId2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessagesForAccountId2 method, of class Account.
     */
    @Test
    public void testSetMessagesForAccountId2() {
        System.out.println("setMessagesForAccountId2");
        Set messagesForAccountId2 = null;
        Account instance = new Account();
        instance.setMessagesForAccountId2(messagesForAccountId2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvents_1 method, of class Account.
     */
    @Test
    public void testGetEvents_1() {
        System.out.println("getEvents_1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getEvents_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvents_1 method, of class Account.
     */
    @Test
    public void testSetEvents_1() {
        System.out.println("setEvents_1");
        Set events_1 = null;
        Account instance = new Account();
        instance.setEvents_1(events_1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessagesForAccountId1 method, of class Account.
     */
    @Test
    public void testGetMessagesForAccountId1() {
        System.out.println("getMessagesForAccountId1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getMessagesForAccountId1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessagesForAccountId1 method, of class Account.
     */
    @Test
    public void testSetMessagesForAccountId1() {
        System.out.println("setMessagesForAccountId1");
        Set messagesForAccountId1 = null;
        Account instance = new Account();
        instance.setMessagesForAccountId1(messagesForAccountId1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessagesForAccountId1_1 method, of class Account.
     */
    @Test
    public void testGetMessagesForAccountId1_1() {
        System.out.println("getMessagesForAccountId1_1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getMessagesForAccountId1_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessagesForAccountId1_1 method, of class Account.
     */
    @Test
    public void testSetMessagesForAccountId1_1() {
        System.out.println("setMessagesForAccountId1_1");
        Set messagesForAccountId1_1 = null;
        Account instance = new Account();
        instance.setMessagesForAccountId1_1(messagesForAccountId1_1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class Account.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments method, of class Account.
     */
    @Test
    public void testSetComments() {
        System.out.println("setComments");
        Set comments = null;
        Account instance = new Account();
        instance.setComments(comments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessagesForAccountId2_1 method, of class Account.
     */
    @Test
    public void testGetMessagesForAccountId2_1() {
        System.out.println("getMessagesForAccountId2_1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getMessagesForAccountId2_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessagesForAccountId2_1 method, of class Account.
     */
    @Test
    public void testSetMessagesForAccountId2_1() {
        System.out.println("setMessagesForAccountId2_1");
        Set messagesForAccountId2_1 = null;
        Account instance = new Account();
        instance.setMessagesForAccountId2_1(messagesForAccountId2_1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments_1 method, of class Account.
     */
    @Test
    public void testGetComments_1() {
        System.out.println("getComments_1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getComments_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments_1 method, of class Account.
     */
    @Test
    public void testSetComments_1() {
        System.out.println("setComments_1");
        Set comments_1 = null;
        Account instance = new Account();
        instance.setComments_1(comments_1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffers method, of class Account.
     */
    @Test
    public void testGetOffers() {
        System.out.println("getOffers");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getOffers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOffers method, of class Account.
     */
    @Test
    public void testSetOffers() {
        System.out.println("setOffers");
        Set offers = null;
        Account instance = new Account();
        instance.setOffers(offers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffers_1 method, of class Account.
     */
    @Test
    public void testGetOffers_1() {
        System.out.println("getOffers_1");
        Account instance = new Account();
        Set expResult = null;
        Set result = instance.getOffers_1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOffers_1 method, of class Account.
     */
    @Test
    public void testSetOffers_1() {
        System.out.println("setOffers_1");
        Set offers_1 = null;
        Account instance = new Account();
        instance.setOffers_1(offers_1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
