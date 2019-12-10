---
sidebar: auto
---

# Information Security

## Trust Services Framework

Means to organize IT controls to help ensure system reliability.

**Principles**

* Security -> System access is controlled and restricted
* Confidentiality -> Sensitive data is protected
* Privacy -> Personal information is protected
* Processing integrity -> Data is processed accurately, reliably and in a timely manner, and only by those authorized to do so
* Availability -> Information is available to those who need it

## Cybersecurity

**Management issue** -> Identify a company's most vital information and find a means to protect it.

### Security Life Cycle

* Assess potential threats and select appropriate response
* Develop security policy and communicate policy to all employees
* Acquire and implement solutions to those threats
* Monitor performance to evaluate effectiveness of those solutions

### Mitigating Risk

**Preventive controls**

* People
  * Create security-conscious culture
  * Provide training for security best practices
* Process
  * Place controls on **user action** -> authorization, authentication
* IT Solutions
  * Anti-malware
  * Network access
* Physical security
  * Limit building entry
  * Limit network access

## ISC 8 Domains of Cybersecurity

1. **Security and risk management**
2. Asset security
3. **Security engineering**
4. Communications and network security
5. **Identity and access management**
6. Security assessment and testing
7. **Security operations**
8. **Software development security**

While there are 8 domains, this course will only emphasize 5 -> numbers 1, 3, 5, 7, and 8.

### 1. Security and Risk Management

**Main objectives**

* Have controls in place to support mission of the organization
* All decisions should be based on risk tolerance

**Security fundamentals**

* Confidentiality -> Sensitive data at each point in processing is secure and protected from unauthorized users
* Integrity -> Data is accurate and reliable
* Available -> Data is available at all times to those who need it. If data is destroyed, it is recoverable

**Risk management**

Main goal -> assign dollar value to risk and provide optimal **mitigation** strategy.

* Identify and value assets, then identify and value potential threats
* ==Prioritize== threats
* Make informed decision on appropriate ==mitigation== method

### 3. Security Engineering

Main goal -> create plan to keep data and information safe.

Asks questions like which methods are most optimal, whether encryption is necessary, how to keep physical sites secure, and prioritizing vulnerabilities.

**Encryption methods**

==Cryptography== -> encoding data in a form where only the sender and intended receiver can understand.

* Encryption -> convert data to an unreadable form called ciphertext
* Decryption -> convert data back from ciphertext to readable form

Encryption typically accomplished using an encryption algorithm, which takes as input the plaintext and a **key**.

* **Symmetric** encryption -> sender and receiver uses the same key called a *private key*.
* **Asymmetric** encryption -> sender and receiver uses *different* keys. The first key, the *public key*, is used to encode the message. A *private key*, held by the receiver, is used to decode the message.

### 5. Identity and Access Management

Abbreviated as IAM -> management and use of **digital identities**.

**Access control** -> only authorized users should be able to access confidential data.

* Dynamic/single-use passwords
  * Use token device -> password generator
* Single sign-on
  * Use same username/password to enter various aspects of a system
* Biometrics
  * Analyze personal attributes to grant access -> fingerprints, face recognition, retina/palm scans
* Multi-factor authentication -> combination of above

### 7. Security Operations

Mainly concerned with day-to-day operations and security of system resources.

* Detecting and protecting critical business information

**Control layers**

* Administrative -> Security policies, standards, and guidelines
* Technical -> Logical access control mechanisms e.g. anti-virus software, firewalls
* Physical -> Facility access, intrunsion detection

**Firewalls**

* Border router -> Connects internal router(s) to internet
* Firewall -> Combination of security algorithms and router protocols that prevent outsiders from accessing internal information
  * **Low-level security**
  * **High-level security**
* DMZ -> Zone where web servers are located, typically between first low-level firewall and second high-level firewall
* Honeypot -> Server in DMZ that has attractive but irrelevant information
  * Used to "bait" hackers

**Disaster recovery**

Goals:

* Minimize loss
* Provide temporary methods
* Quickly resume normal operations

Recovery plan should include three major components:

* Assess company's critical needs
* Prioritize assets for recovery
* Establish recovery strategies and procedures

**Backup methods**

* Regularly scheduled backups
* **Hot site** -> Recovery method that can be leased to provide IT services in event of disaster; operational in ==few hours==
* **Warm site** -> Partially configured recovery service; operational in ==few days==
* **Cold site** -> Provide basic needs but no IT equipment; operational in ==several== days

### 8. Software Development Security

Goal -> Provide security at **every step** of the software development process.
