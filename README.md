**Project: Volume Adjuster using Arduino and Java**

**Introduction:**

While playing online games, I faced difficulties adjusting the laptop's volume due to a broken "Fn key". This inspired me to create a device using an Arduino board to adjust system volume without minimizing applications.

**Context**

The device functions as a "wired remote controller" using a potentiometer connected to an Arduino board. Rotating the potentiometer adjusts the laptop's system volume, displayed on the Arduino's OLED screen. This solution benefits users with broken laptop keys, particularly the Fn or volume keys.

**Technical Specifications**

The Arduino receives potentiometer data and sends it to a Java program via the Arduino IDE. The Java program converts data to adjust system volume using the "NirCMD" library. The program includes a delay to optimize performance and prevent system crashes.

**Components List**

Grove board

OLED screen

Potentiometer

Java Program

Arduino IDE


**Procedure**

I brainstormed components needed for the project and integrated the potentiometer and OLED screen with the Arduino. I utilized the NirCMD library for interfacing with the system volume. Implementing a delay in the program significantly improved performance.

**Test**

The program successfully adjusts system volume based on potentiometer rotation, displaying changes on the Arduino's OLED screen.

**Brief summary**

Tested and debugged program for correctness.

Built an application to meet specific requirements using an API.

Utilized ready-made collections to solve problems.

Developed an event-driven application controlling sensors and actuators.

Programmed applications using object-oriented principles.

**Contingency**

I encountered system overheating and crashes during development, resolved by adding delays in the program execution.

**Conclusion**

The project demonstrates the integration of software and hardware to solve a real-world problem. 

**References**

NirCMD v2.86: http://www.nirsoft.net/utils/nircmd.html

Microsoft Documentation: https://docs.microsoft.com/en-us/dotnet/api/system.threading.thread.sleep?view=net-5.0

Java Tutorial: https://hajsoftutorial.com/category/java-runtime-and-process/
