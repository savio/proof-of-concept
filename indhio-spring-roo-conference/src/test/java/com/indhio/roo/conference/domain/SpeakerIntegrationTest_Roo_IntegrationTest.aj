// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.indhio.roo.conference.domain;

import com.indhio.roo.conference.domain.Speaker;
import com.indhio.roo.conference.domain.SpeakerDataOnDemand;
import com.indhio.roo.conference.domain.SpeakerIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SpeakerIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SpeakerIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SpeakerIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SpeakerIntegrationTest: @Transactional;
    
    @Autowired
    SpeakerDataOnDemand SpeakerIntegrationTest.dod;
    
    @Test
    public void SpeakerIntegrationTest.testCountSpeakers() {
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", dod.getRandomSpeaker());
        long count = Speaker.countSpeakers();
        Assert.assertTrue("Counter for 'Speaker' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SpeakerIntegrationTest.testFindSpeaker() {
        Speaker obj = dod.getRandomSpeaker();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to provide an identifier", id);
        obj = Speaker.findSpeaker(id);
        Assert.assertNotNull("Find method for 'Speaker' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Speaker' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SpeakerIntegrationTest.testFindAllSpeakers() {
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", dod.getRandomSpeaker());
        long count = Speaker.countSpeakers();
        Assert.assertTrue("Too expensive to perform a find all test for 'Speaker', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Speaker> result = Speaker.findAllSpeakers();
        Assert.assertNotNull("Find all method for 'Speaker' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Speaker' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SpeakerIntegrationTest.testFindSpeakerEntries() {
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", dod.getRandomSpeaker());
        long count = Speaker.countSpeakers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Speaker> result = Speaker.findSpeakerEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Speaker' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Speaker' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SpeakerIntegrationTest.testFlush() {
        Speaker obj = dod.getRandomSpeaker();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to provide an identifier", id);
        obj = Speaker.findSpeaker(id);
        Assert.assertNotNull("Find method for 'Speaker' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifySpeaker(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Speaker' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SpeakerIntegrationTest.testMergeUpdate() {
        Speaker obj = dod.getRandomSpeaker();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to provide an identifier", id);
        obj = Speaker.findSpeaker(id);
        boolean modified =  dod.modifySpeaker(obj);
        Integer currentVersion = obj.getVersion();
        Speaker merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Speaker' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void SpeakerIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", dod.getRandomSpeaker());
        Speaker obj = dod.getNewTransientSpeaker(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Speaker' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Speaker' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Speaker' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SpeakerIntegrationTest.testRemove() {
        Speaker obj = dod.getRandomSpeaker();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Speaker' failed to provide an identifier", id);
        obj = Speaker.findSpeaker(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Speaker' with identifier '" + id + "'", Speaker.findSpeaker(id));
    }
    
}