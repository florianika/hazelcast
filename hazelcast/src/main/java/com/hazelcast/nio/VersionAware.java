/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.nio;

/**
 * Enables getting the version from the implementing object.
 * It may be any Version (cluster version, node version, custom version, etc.) It's up to the implementer.
 *
 * @since 3.8
 */
public interface VersionAware {

    /**
     * @return the version or Version.UNKNOWN if version is unknown to the object.
     */
    Version getVersion();

}
