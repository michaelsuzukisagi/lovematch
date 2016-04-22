/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.alfresco.demo.demo_alfresco_amp.demoamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.cmr.security.PersonService;
import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;
/**
 * A demonstration Java controller for the Love match Web Script.
 * In this sample we purposely introduce code that will lead to
 * performance problems.
 * 
 * @author Michael Suzuki 
 * @param <E>
 * @since 2.1.0
 */
public class LoveMatchWebScript<E> extends DeclarativeWebScript {

    private PersonService personService;
    private NodeService nodeService;
    private static Map<Long, List<String>> bk = new HashMap<Long, List<String>>();
    public Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache) 
    {
        Map<String, Object> data = new HashMap<String,Object>();
        data.put("count" ,personService.getAllPeople().size());
        List<String> users = new ArrayList<String>();
        for(NodeRef userRef : personService.getAllPeople())
        {
            String firstName = nodeService.getProperty(userRef, ContentModel.PROP_FIRSTNAME).toString();
            String lastName = nodeService.getProperty(userRef, ContentModel.PROP_LASTNAME).toString();
            String username = firstName + " " + lastName;
            users.add(username);
        }
        bk.put(System.currentTimeMillis(), users);
        System.out.println(bk.size());
        Collections.shuffle(users);
        data.put("user1" , users.get(0));
        data.put("user2" , users.get(1));
        Double score = Math.random()*100;
        data.put("score" , score.intValue());
        
        return data;
    }
    public void setPersonService(PersonService personService) 
    {
        this.personService = personService;
    }
    public void setNodeService(NodeService nodeService) {
        this.nodeService = nodeService;
    }
}