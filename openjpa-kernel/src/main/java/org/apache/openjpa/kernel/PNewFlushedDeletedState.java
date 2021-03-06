/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.kernel;

/**
 * Lifecycle state.
 * Represents an instance that was made persistent within the
 * current	transaction, flushed, and subsequently deleted.
 *
 * @author Patrick Linskey
 */
class PNewFlushedDeletedState extends PCState {
    private static final long serialVersionUID = 1L;

    @Override
    PCState flush(StateManagerImpl context) {
        return PNEWFLUSHEDDELETEDFLUSHED;
    }

    @Override
    PCState commit(StateManagerImpl context) {
        return TRANSIENT;
    }

    @Override
    PCState commitRetain(StateManagerImpl context) {
        return TRANSIENT;
    }

    @Override
    PCState rollback(StateManagerImpl context) {
        return TRANSIENT;
    }

    @Override
    PCState rollbackRestore(StateManagerImpl context) {
        context.restoreFields();
        return TRANSIENT;
    }

    @Override
    PCState persist(StateManagerImpl context) {
        return PNEW;
    }

    @Override
    PCState nontransactional(StateManagerImpl context) {
        return error("deleted", context);
    }

    @Override
    PCState release(StateManagerImpl context) {
        return error("deleted", context);
    }

    @Override
    PCState beforeWrite(StateManagerImpl context, int field, boolean mutate) {
        return error("deleted", context);
    }

    @Override
    PCState beforeOptimisticWrite(StateManagerImpl context, int field,
        boolean mutate) {
        return error("deleted", context);
    }

    @Override
    boolean isTransactional() {
        return true;
    }

    @Override
    boolean isPersistent() {
        return true;
    }

    @Override
    boolean isNew() {
        return true;
    }

    @Override
    boolean isDeleted() {
        return true;
    }

    @Override
    boolean isDirty() {
        return true;
    }

    @Override
    public String toString() {
        return "Persistent-New-Flushed-Deleted";
    }
}
