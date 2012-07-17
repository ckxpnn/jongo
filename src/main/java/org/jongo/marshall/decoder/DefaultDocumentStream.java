/*
 * Copyright (C) 2011 Benoit GUEROUT <bguerout at gmail dot com> and Yves AMSELLEM <amsellem dot yves at gmail dot com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jongo.marshall.decoder;

import com.mongodb.DBEncoder;
import com.mongodb.DefaultDBEncoder;
import org.bson.BSONObject;
import org.bson.io.BasicOutputBuffer;
import org.bson.io.OutputBuffer;
import org.jongo.marshall.DocumentStream;

public class DefaultDocumentStream implements DocumentStream {

    private final OutputBuffer buffer;
    private final BSONObject dbo;

    public DefaultDocumentStream(BSONObject dbo) {
        this.dbo = dbo;
        this.buffer = new BasicOutputBuffer();
        DBEncoder dbEncoder = DefaultDBEncoder.FACTORY.create();
        dbEncoder.writeObject(buffer, dbo);
    }

    public int getOffset() {
        return 0;
    }

    public int getSize() {
        return buffer.size();
    }

    public byte[] getData() {
        return buffer.toByteArray();
    }

    public BSONObject asBSONObject() {
        return dbo;
    }
}
