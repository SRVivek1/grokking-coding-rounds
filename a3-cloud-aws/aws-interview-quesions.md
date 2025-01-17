## AWS S3 (Simple Storage Service)
<span style="color: blue;">**1. What is the default maximum bucket size in Amazon S3 ?**</span>
  - The default maximum bucket size in Amazon S3 is effectively unlimited in terms of the total storage capacity for a bucket. It allows to store unlimited amount of data. 
  - **Limitations:**
    - Individual objects can be as large as **5 TB**. 
    - However, each object can only be uploaded in parts (if greater than **5 GB**), and the total number of objects you can store is also practically unlimited.

<span style="color: blue;">2. **What is the default max number of buckets allowed per aws account ?**</span>
  - Amazon S3 allows to create up to ***100 buckets per AWS account*** by default.
  - However, if we need more than 100 buckets, we can request a limit increase through the AWS Support Center. 
    - Keep in mind that having many buckets can complicate management, so AWS recommends using prefixes and folder structures within a smaller number of buckets (if possible) to organize your data.