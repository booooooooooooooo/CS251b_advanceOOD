Dear Prof. Pearce,


1. Package agency is in folder agency. To save your time from setting CLASSPATH, I copy and put the agency folder in both prisonerDilemma and ultraDome. Description about files in agency platform are below.

Facilitator.java does message exchange and performs synchronization. Facilitator is an abstract class. The react method is to be implemented in different application.

Agent is a thread. It has a Message. Generally, agent keeps unchanged in application.

Message stores the information of Agent. Message is to be implemented in different application.


2. To run prisonerDilemma, enter prisonerDilemma folder and type in terminal "javac Main.java" and "java Main". Description about other files are below.

Judge.java extends Facilitator.java

Strategy.java implements Message.java


3. To run ultraDome, enter ultraDome foler and type in terminal "javac Main.java" and "java Main". Description about other files are below.

ultraDome.java extends Facilitator.java

Status.java implements Message.java

Shield.java uses decorator pattern

Skin is Enumerator

Weapon is Enumerator. I didn't use Strategy pattern here since I feel using Enumerator makes the application more straight forward.

Thanks.
Bo Li
