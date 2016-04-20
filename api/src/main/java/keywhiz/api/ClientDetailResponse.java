/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package keywhiz.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import keywhiz.api.model.Client;
import keywhiz.api.model.Group;
import keywhiz.api.model.SanitizedSecret;

public class ClientDetailResponse {
  @JsonProperty
  public final long id;

  @JsonProperty
  public final String name;

  @JsonProperty
  public final String description;

  @JsonProperty
  public final ApiDate creationDate;

  @JsonProperty
  public final ApiDate updateDate;

  @JsonProperty
  public final String createdBy;

  @JsonProperty
  public final String updatedBy;

  /** List of secrets the group has access to. The secrets do not contain content. */
  @JsonProperty
  public final ImmutableList<SanitizedSecret> secrets;

  @JsonProperty
  public final ImmutableList<Group> groups;

  public ClientDetailResponse(@JsonProperty("id") long id,
      @JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("creationDate") ApiDate creationDate,
      @JsonProperty("updateDate") ApiDate updateDate,
      @JsonProperty("createdBy") String createdBy,
      @JsonProperty("updatedBy") String updatedBy,
      @JsonProperty("groups") ImmutableList<Group> groups,
      @JsonProperty("secrets") ImmutableList<SanitizedSecret> secrets) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.creationDate = creationDate;
    this.updateDate = updateDate;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.groups = groups;
    this.secrets = secrets;
  }

  public static ClientDetailResponse fromClient(Client client, ImmutableList<Group> groups,
      ImmutableList<SanitizedSecret> secrets) {
    return new ClientDetailResponse(client.getId(),
        client.getName(),
        client.getDescription(),
        client.getCreatedAt(),
        client.getUpdatedAt(),
        client.getCreatedBy(),
        client.getUpdatedBy(),
        groups,
        secrets);
  }
}
