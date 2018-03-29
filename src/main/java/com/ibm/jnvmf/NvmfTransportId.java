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

import java.net.InetSocketAddress;
import java.util.Objects;

public class NvmfTransportId {

  private final InetSocketAddress address;
  private final NvmeQualifiedName subsystemNqn;

  public NvmfTransportId(InetSocketAddress address, NvmeQualifiedName subsystemNqn) {
    this.address = address;
    this.subsystemNqn = subsystemNqn;
  }

  public InetSocketAddress getAddress() {
    return address;
  }

  public NvmeQualifiedName getSubsystemNqn() {
    return subsystemNqn;
  }

  @Override
  public String toString() {
    return "Transport address = " + address + ", subsystem NQN = " + subsystemNqn;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    NvmfTransportId that = (NvmfTransportId) obj;
    return Objects.equals(address, that.address) && Objects.equals(subsystemNqn, that.subsystemNqn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, subsystemNqn);
  }
}
