# AWS : EC2 Instance purchasing options

-----

As a software architect, understanding the different EC2 purchasing options is crucial for optimizing cost, performance, and reliability. This is a core topic for AWS certifications and architect interviews. Let's break down the key EC2 purchasing models.

## 1\. Concept Overview

AWS offers various ways to pay for EC2 instances, moving beyond the simple pay-as-you-go model. These options allow you to trade off flexibility for cost savings. 
* The fundamental concept is a **spectrum of commitment**: 
  * The more you commit (in time or usage), the greater the discount you receive. 
  * An architect's job is to analyze the workload and choose the right mix of these options to meet business needs at the lowest possible cost.

-----

## 2\. Detailed Explanation

### On-Demand Instances

This is the most flexible option. You pay for compute capacity by the hour or second (with a 60-second minimum) with no long-term commitments.
* Pay for what you use:
  * Linux or Windows - Billing per secon, after the first minute.
  * All other operating systems - billing per hour.
* Has the highest cost but no upfront payment.
* No long-term commitment.

  * **When to use:** 
    * For unpredictable or spiky workloads, development and testing environments, or applications that cannot be interrupted.
  * **Why it's used:** 
    * It offers maximum flexibility and requires no upfront payment. You simply pay for what you use.

* **Recommended for** short-term and un-interrupted woorloads, where you can't predict how the application will behave. 

-----

### Reserved Instances (RI)

Reserved Instances are a **billing discount** applied to your On-Demand usage. They are not a physical instance but a reservation of a specific configuration (Instance Type, Region, Tenency, OS). 
* **Reserved Instance's scope -** Regionl or Zonal (reserve capacity in an AZ).
* You commit to a **1-year (+discount) or 3-year (+++discount) term** for a significant discount **(up to 72%)**.
* **Different RI options:**
  * **Standard RI:** 
    * Offers the highest discount but is the least flexible. 
    * The reservation is tied to a specific instance family, type, and region, and cannot be changed.
  * **Convertible RI:** 
    * Provides a lower discount but allows you to change the instance family, OS, and tenancy during the term. 
    * This is great for evolving applications.
      * Under this category up to **66% discount** available.
  * **Payment Options:** 
    * You can choose to pay **All Upfront** (largest discount), **Partial Upfront** (less discount), or **No Upfront** (smallest discount).

* **Recommended for** steady-state usage applications (think database).
* **Note:** 
  * You can buy and sell in the **Reserved Instance Marketplce**.
  * The discount % may change over time by AWS. The exact number is not needed for the exam.

-----

### Savings Plans [TODO]

This is a more flexible and modern alternative to Reserved Instances. You commit to a consistent amount of compute usage per hour, measured in dollars ($/hr) for a 1- or 3-year term.

  * **Compute Savings Plans:** 
    * The most flexible. 
    * The discount automatically applies to any EC2 instance usage, regardless of instance family, size, region, OS, or tenancy. 
    * It also applies to AWS Fargate and AWS Lambda.
  * **EC2 Instance Savings Plans:** 
    * Offers higher savings than Compute Savings Plans but is less flexible. 
    * The commitment is to a specific EC2 instance family in a region, but you can change instance size, OS, and tenancy.

-----

#### Spot Instances

These are unused EC2 instances available at a steep discount (up to 90% off the On-Demand price). The catch? AWS can terminate them with a two-minute warning if the capacity is needed for On-Demand or Reserved Instance users.

  * **When to use:** For fault-tolerant, stateless, or flexible workloads like big data processing, CI/CD, batch jobs, or rendering farms.
  * **Why it's used:** Tremendous cost savings. The key is that the application must be designed to handle interruptions gracefully.

#### Dedicated Hosts

A physical EC2 server dedicated for your use. You have full control and visibility over the underlying hardware, including the number of sockets and physical cores.

  * **When to use:** Primarily for bringing your own software licenses (**BYOL**) that require per-socket, per-core, or per-VM licensing. Also used for strict regulatory or compliance requirements.
  * **Billing:** You are billed for the entire physical host, not per instance, so it's a fixed cost.

#### Dedicated Instances

Instances that run on hardware dedicated to a single customer account, physically isolated from other accounts. Unlike Dedicated Hosts, you don't have visibility or control over the host hardware and can't use your own licenses that are tied to physical cores/sockets.

  * **When to use:** For compliance or security requirements that mandate physical isolation from other customers.
  * **Billing:** You are charged at a premium over On-Demand rates.

#### On-Demand Capacity Reservations

This is not a pricing model but a way to reserve capacity. You reserve a specific number of instances in a particular Availability Zone for any duration.

  * **When to use:** For mission-critical workloads that require guaranteed capacity, especially in regions with high demand.
  * **Key Note:** You pay the On-Demand rate for the reserved capacity whether you use it or not. It's often combined with Savings Plans or Reserved Instances to get a billing discount on top of the reserved capacity.

-----

### 3\. Code Examples

N/A - This topic is about billing and provisioning, not code implementation.

-----

### 4\. Diagrams

**EC2 Purchasing Options - Cost vs. Flexibility**

**Mermaid.js Diagram: Decision Flow**

```mermaid
graph TD
    A[Start: What are my workload needs?] --> B{Can my application be interrupted?};
    B -- Yes --> C[Use Spot Instances];
    B -- No --> D{Do I have a predictable, long-term workload?};
    D -- Yes --> E{Do I need a specific instance family/region?};
    E -- Yes --> F[Use EC2 Instance Savings Plans or Reserved Instances];
    E -- No --> G[Use Compute Savings Plans];
    D -- No --> H[Use On-Demand Instances];
    H --> I{Do I need guaranteed capacity?};
    I -- Yes --> J[Use On-Demand Capacity Reservations];
    H --> K[Do I have strict licensing or compliance needs?];
    K -- Yes --> L{Do I need to manage licenses per host?};
    L -- Yes --> M[Use Dedicated Hosts];
    L -- No --> N[Use Dedicated Instances];
```

-----

### 5\. Real-World Applications

  * **Netflix:** Uses a mix of On-Demand, Reserved, and Spot Instances to manage their massive streaming and data processing workloads. They use Spot Instances for video encoding and non-critical batch jobs to save costs.
  * **Gaming Companies:** Often use Spot Fleets to spin up temporary, large-scale compute clusters for game server testing, ensuring they can handle millions of concurrent players without paying a fortune.
  * **Financial Institutions:** May use Dedicated Instances or Dedicated Hosts to meet stringent regulatory compliance requirements, ensuring their data is physically isolated.
  * **SaaS Startups:** A new startup might start with On-Demand Instances for flexibility and ease of use. As their business stabilizes and they identify consistent workloads, they transition to Savings Plans to reduce costs.

-----

### 6\. Advantages & Drawbacks

  * **On-Demand:**
      * **Pros:** Ultimate flexibility, no commitment.
      * **Cons:** Highest cost, no guaranteed capacity.
  * **Reserved Instances/Savings Plans:**
      * **Pros:** Significant cost savings (up to 72%), predictable billing.
      * **Cons:** Requires commitment, less flexible than On-Demand. RI is less flexible than SP.
  * **Spot Instances:**
      * **Pros:** Massive cost savings (up to 90%).
      * **Cons:** Can be interrupted at any time, not suitable for stateful or critical workloads.
  * **Dedicated Hosts/Instances:**
      * **Pros:** Physical isolation, compliance benefits, BYOL support (Hosts).
      * **Cons:** Premium cost, management overhead (Hosts).
  * **Capacity Reservations:**
      * **Pros:** Guaranteed capacity, crucial for mission-critical apps.
      * **Cons:** No discount, you pay even if not used.

-----

### 7\. Trade-offs

The primary trade-off is **Cost vs. Flexibility**.

  * **On-Demand** gives you maximum flexibility at the highest cost.
  * **Spot Instances** give you maximum cost savings with the least flexibility (due to interruption risk).
  * **Reserved Instances/Savings Plans** strike a balance, offering good discounts for a long-term commitment.

The decision is about finding the right equilibrium for your specific application. A well-designed architecture will often use a combination of these.

-----

### 8\. Best Practices

  * **Analyze your workload:** Use AWS Cost Explorer to analyze historical usage and identify predictable workloads that can benefit from Savings Plans or RIs.
  * **Adopt a "blended" approach:** Use a combination of On-Demand for dynamic, spiky workloads, Savings Plans for stable compute, and Spot Instances for fault-tolerant batch jobs.
  * **Automate with AWS tools:** Use Auto Scaling Groups with a mix of On-Demand and Spot instances to automatically manage capacity and costs. Use AWS Budgets to monitor spending.
  * **Start small:** For long-term commitments, start with a 1-year Savings Plan and monitor usage.
  * **Choose Savings Plans over Reserved Instances:** For new commitments, Savings Plans offer similar discounts with much greater flexibility. RIs are still useful for specific use cases like reserving capacity in a particular AZ.

-----

### 9\. Interview Angle

  * **"What are the different EC2 purchasing options?"**
      * *Answer:* Start by listing them (On-Demand, RIs, SPs, Spot, Dedicated) and then provide a one-sentence summary for each. Frame the discussion around the core trade-off: cost vs. flexibility.
  * **"Explain the difference between Reserved Instances and Savings Plans."**
      * *Answer:* Highlight that SPs are a more flexible, dollar-based commitment that applies across instance types and services (Compute SPs), while RIs are tied to a specific instance configuration. Mention that AWS now recommends SPs for most use cases.
  * **"When would you use Spot Instances?"**
      * *Answer:* Use the keywords "fault-tolerant," "stateless," "non-critical," and "interruptible." Give concrete examples like big data processing (Spark, Hadoop), video rendering, and CI/CD pipelines.
  * **"How would you optimize EC2 costs for a new application?"**
      * *Answer:* Start with On-Demand for development. Once the application is in production and you have a stable baseline of usage (e.g., a database and a web server), purchase a Savings Plan for that base load. Use Auto Scaling with a mix of On-Demand and Spot instances to handle the variable traffic.

-----

### 10\. Online References

  * [AWS EC2 Pricing](https://aws.amazon.com/ec2/pricing/)
  * [AWS Savings Plans](https://aws.amazon.com/savingsplans/)
  * [AWS re:Invent 2024 - Managing Amazon EC2 capacity and availability (CMP319)](https://www.youtube.com/watch?v=TyFMsx9PVeM)

-----

### 11\. Summary

The AWS EC2 purchasing options provide a powerful toolkit for cost optimization. **On-Demand** is for flexibility, **Savings Plans/Reserved Instances** are for long-term savings on predictable workloads, and **Spot Instances** are for huge discounts on interruptible jobs. **Dedicated Hosts/Instances** serve specific compliance and licensing needs, while **Capacity Reservations** ensure availability for critical applications. The best strategy is a thoughtful combination of these to match your application's unique requirements.

-----

### 12\. Extra Insights

Think of it as renting a car:

  * **On-Demand:** Renting a car for a day. You pay the standard rate, but you can return it anytime.
  * **Reserved Instances/Savings Plans:** Leasing a car for a year or more. You get a much better monthly rate, but you're committed.
  * **Spot Instances:** Renting a car that's not currently being used by anyone else, at a massive discount. The catch is that the owner can call you and ask for it back with a 2-minute warning.
  * **Dedicated Hosts:** Buying a parking space in a specific garage so you can park your car there and only your car, always. This is a good option if you have a special vehicle (license) that only works in that specific garage.

### 13\. For AWS certification exam perspective:

  * **Key Notes:**
      * Understand the key differences between **Savings Plans** and **Reserved Instances**, especially that SPs are a dollar-per-hour commitment and RIs are a commitment to a specific instance configuration.
      * Remember that **Reserved Instances** and **Savings Plans** apply to your billing, not a physical instance.
      * **Spot Instances** can be terminated with a two-minute warning.
      * **Dedicated Hosts** are required for certain server-bound licenses (BYOL).
      * **Capacity Reservations** are for guaranteed capacity, not cost savings. They are billed at the On-Demand rate.
      * The highest potential savings come from a 3-year term with a full upfront payment.
      * A common trick question on the exam is about using On-Demand instances vs. Reserved Instances for a 24/7 workload; the correct answer is almost always the more cost-effective Reserved Instance.

The video below explains the difference between On-Demand and Spot Instances in a concise way.
[AWS re:Invent 2024 - Managing Amazon EC2 capacity and availability (CMP319)](https://youtu.be/TyFMsx9PVeM)

-----

<ul class="flex-list">
    <li>
        <a href="https://srvivek1.github.io/">Go to Home</a>
    </li>
    <li><a href="https://github.com/SRVivek1/">Author: Vivek K Singh</a></li>
</ul>

<center>
<p> ------ </p>
</center>

<!-- HTML styling -->
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
heading {
  color: blue;
  font-size: 20px;
}

.flex-list {
    display: flex; /* Makes the <ul> a flex container */
    list-style-type: none;
    margin: 0;
    padding: 0;
    justify-content: space-between;
}

.flex-list li {
    /* No display change needed, flex items are already inline */
    margin-right: 20px;
}

</style>