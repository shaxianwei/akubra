/* $HeadURL:: http://gandalf.topazproject.org/svn/head/topaz/core/src/main/java/org/topa#$
 * $Id: ClassMetadata.java 5434 2008-04-12 11:41:51Z ronald $
 *
 * Copyright (c) 2007-2008 by Fedora Commons Inc.
 * http://www.fedoracommons.org
 * 
 * In collaboration with Topaz Inc.
 * http://www.topazproject.org
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
package org.fedoracommons.akubra.fs;

import java.net.URI;

/**
 * Allocates unique filenames.
 * 
 * @author Chris Wilper
 */
public interface FilenameAllocator {

  /**
   * Allocates a new filename.
   *
   * The filename is guaranteed to be unique, and therefore must not be
   * solely based upon the blobId, if provided.
   * 
   * @param blobId id of the blob to be stored, may be null.
   *        If provided, an implementation may or may not use the
   *        blobId for filename allocation.
   * @return the filename.
   */
  String allocate(URI blobId);

  /**
   * Gets the blobId from the given filename, if possible.
   * 
   * @param filename the filename (previously generated by this type of
   *        allocator) from which to extract the blobId.
   * @return the blobId if it can be determined from the filename,
   *         null otherwise.
   */
  URI getBlobId(String filename);
}