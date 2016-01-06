/**
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.kaczmarzyk.spring.data.jpa.domain;

import java.text.ParseException;

import net.kaczmarzyk.spring.data.jpa.utils.Converter;


/**
 * @author Tomasz Kaczmarzyk
 */
abstract class DateSpecification<T> extends PathSpecification<T> {

    protected Converter converter;

    protected DateSpecification(String path, String... args) throws ParseException {
        this(path, args, null);
    }
    
    protected DateSpecification(String path, String[] args, String[] config) throws ParseException {
        super(path);
        if (config != null && config.length != 1) {
            throw new IllegalArgumentException("invalid configuration (expected only date format): " + config);
        }
        String dateFormat = config != null ? config[0] : null;
        this.converter = Converter.withDateFormat(dateFormat);
    }
}
