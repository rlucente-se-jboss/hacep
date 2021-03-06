/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.redhat.hacep.playground.cache;

import it.redhat.hacep.model.Key;

import java.util.Objects;

public class SuricataFactKey extends Key<String> {
	private static final long serialVersionUID = 5920525406435676121L;
	
	private String id;

    public SuricataFactKey(String id, String hostname) {
        super(hostname);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id + "::" + getGroup();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuricataFactKey)) return false;
        if (!super.equals(o)) return false;
        SuricataFactKey suricataFactKey = (SuricataFactKey) o;
        return Objects.equals(id, suricataFactKey.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

}
