# Enterprise Systems Architecture and Ecosystem

## Business Strategy

Business strategy should align with information strategy. Unfortunately this doesn't always happen.

* IT departments don't have a clear understanding of what is important to business strategy.
* Business don't understand value of IT.
* IT decisions are made separately

## Integrated Enterprise Systems

Each department in an organization typically has its own standalone system.

* **Problem**
  * Data has to be entered more than once
  * Data cannot be shared across departments

Solution -> ==3-tier integrated enterprise system==

Tiers:

* User
* Application
* Database

With enterprise system, data can flow through different functional areas as required. All involved systems in the organization can freely exchange data.

* Benefits
  * Improve communication, coordinate activities, and reduce duplication
  * Encourages best practices
  * Enable information sharing with supply chain partners
* Drawbacks
  * Change management -> must redesign current practices to use enterprise system

## Client/Server Architecture

* **Client** -> An application or process that makes use of a service.
* **Server** -> An application or process that *provides* a service in response to a client request.

### 2-Tier Architecture

==2-tier== -> consist of only a client and a server.

* Roles of ==client==
  * Provide interface for end users to easily send requests to server
  * Submit requests to server applications
  * Known as **fat clients**
* Roles of ==server==
  * Listen and respond to many concurrent requests
  * Manage resources required to fulfill those requests

**Thin clients** -> clients with limited features, typically only presentation logic and network communication support

### Cloud Computing

Cloud computing -> computer system resources managed by third party, typically communicated over internet.

* Typical models -> IaaS, PaaS, DaaS, SaaS, etc.
  * IaaS (Infrastructure) -> Computer hardware and networking on an on-demand basis
  * SaaS (Software) -> Usage of a software application on an on-demand basis
  * PaaS (Platform) -> Application development tools on an on-demand basis
