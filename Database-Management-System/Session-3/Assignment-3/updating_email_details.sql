/*
Updating user email
*/


UPDATE user
   SET email = CASE user_id
    WHEN 1 THEN 'aakanksha.raj@metacube.com'
    WHEN 2 THEN 'abhay.verma@metacube.com'
    WHEN 3 THEN 'ajay.vijay@metacube.com'
    WHEN 4 THEN 'akshita.agrawal@metacube.com'
    WHEN 5 THEN 'arjita.marelay@metacube.com'
    WHEN 6 THEN 'ayushi.khandelwal@metacube.com'
    WHEN 7 THEN 'bhavika.mathur@metacube.com'
    WHEN 8 THEN 'chirag.jain@metacube.com'
    WHEN 9 THEN 'deekshika.sharma@metacube.com'
    WHEN 10 THEN 'dipanshu.sharma@metacube.com'
    WHEN 11 THEN 'ishita.mathur@metacube.com'
    WHEN 12 THEN 'jai.garg@metacube.com'
    WHEN 13 THEN 'jitendra.chandwani@metacube.com'
    WHEN 14 THEN 'khushboo.saxena@metacube.com'
    WHEN 15 THEN 'komal.khatri@metacube.com'
    WHEN 16 THEN 'mayank.moolchandani@metacube.com'
    WHEN 17 THEN 'mohammed.jukker@metacube.com'
    WHEN 18 THEN 'mohit.sharma@metacube.com'
    WHEN 19 THEN 'namrata.agarwal@metacube.com'
    WHEN 20 THEN 'nikhil.saxena@metacube.com'
    WHEN 21 THEN 'niraj.gupta@metacube.com'
    WHEN 22 THEN 'prakalpa.rathore@metacube.com'
    WHEN 23 THEN 'pratiksha.jain@metacube.com'
    WHEN 24 THEN 'rachna.jadam@metacube.com'
    WHEN 25 THEN 'rahul.jangid@metacube.com'
    WHEN 26 THEN 'rahul.sharma3@metacube.com'
    WHEN 27 THEN 'rajendra.rathore@metacube.com'
    WHEN 28 THEN 'ramjilal.choudhary@metacube.com'
    WHEN 29 THEN 'richa.jain1@metacube.com'
    WHEN 30 THEN 'sankalp.vyas@metacube.com'
    WHEN 31 THEN 'shubham.jain1@metacube.com'
    WHEN 32 THEN 'shubham.joshi@metacube.com'
    WHEN 33 THEN 'somi.vishnoi@metacube.com'
    WHEN 34 THEN 'surbhi.singh@metacube.com'
    WHEN 35 THEN 'swati.bhatia@metacube.com'
    WHEN 36 THEN 'tanu.mittal@metacube.com'
    WHEN 37 THEN 'twinkle.garg@metacube.com'
    WHEN 38 THEN 'utkarsh.mundra@metacube.com'
    WHEN 39 THEN 'vaibhav.gautam@metacube.com'
 END
 WHERE user_id BETWEEN 1 AND 39;