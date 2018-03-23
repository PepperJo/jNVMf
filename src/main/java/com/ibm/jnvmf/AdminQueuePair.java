/*
 * Copyright (C) 2018, IBM Corporation
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
 *
 */

package com.ibm.jnvmf;

import java.io.IOException;

public class AdminQueuePair extends QueuePair {
    /* NVMf Spec 1.0 - 5.3
    *  32 entries is the minimum admin submission queue size */
    final static short MINIMUM_SUBMISSION_QUEUE_SIZE = 32;

    AdminQueuePair(Controller controller) throws IOException {
        /* NVMf Spec 1.0 - 7.3.2 Admin and Fabrics command do not carry any incapsule data */
        super(controller, QueueID.ADMIN, MINIMUM_SUBMISSION_QUEUE_SIZE);
    }

    @Override
    FabricsConnectResponseCQE connect() throws IOException {
        FabricsConnectResponseCQE cqe = super.connect();
        getController().setControllerId(cqe.success().getControllerId());
        return cqe;
    }
}
