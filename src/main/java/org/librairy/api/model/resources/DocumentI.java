/*
 * Copyright (c) 2016. Universidad Politecnica de Madrid
 *
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 *
 */

package org.librairy.api.model.resources;

import lombok.Data;

/**
 * Created by cbadenes on 22/01/16.
 */
@Data
public class DocumentI {

    String uri;

    String title;

    String subject;

    String publishedOn;

    String publishedBy;

    String authoredOn;

    String authoredBy;

    String retrievedOn;

    String retrievedFrom;

    String contributedBy;

    String format;

    String language;

    String description;

    String rights;

    String content;

    String tokens;
}
