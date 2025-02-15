// ------------------------------------------------------------------------------
// Copyright (c) 2017 Microsoft Corporation
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sub-license, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.microsoft.graph.http;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.microsoft.graph.serializer.AdditionalDataManager;
import com.microsoft.graph.serializer.IJsonBackedObject;
import com.microsoft.graph.serializer.ISerializer;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/** Represents the body to use with an OData method */
public class ReferenceRequestBody implements IJsonBackedObject {

    private AdditionalDataManager additionalDataManager = new AdditionalDataManager(this);

    /** the odata id */
    @SerializedName("@odata.id")
    @Expose
    @Nonnull
    public String odataId;

    /**
     * Instanciates a new reference request body from the serialized payload
     * @param payload payload to instanciate the body from
     */
    public ReferenceRequestBody(@Nonnull final String payload) {
        odataId = Objects.requireNonNull(payload, "parameter payload cannot be null");
    }

    /**
     * Sets the raw JSON object
     *
     * @param serializer the serializer
     * @param json       the JSON object to set this object to
     */
    public void setRawObject(@Nonnull final ISerializer serializer, @Nonnull final JsonObject json) {
    }

    @Override
    @Nonnull
    @SuppressFBWarnings
    public final AdditionalDataManager additionalDataManager() {
        return additionalDataManager;
    }
}
