// Import libraries
#include <Arduino.h>
#include <U8x8lib.h>

#define BUTTON 6

// Creates an instance of the ‘ U8X8_SSD1306_128X64_NONAME_HW_I2C ‘ class
auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C ( U8X8_PIN_NONE ) ;

 /* -------------- Initialize the Grove board ------------- */
 void setup () {
     pinMode( A0 , INPUT); // Sets the A0 pin ( POTENTIOMETER ) to INPUT
     pinMode(BUTTON, INPUT); //Sets the D6 pin ( BUTTON ) to INPUT
     
     Serial . begin (9600) ; // Enables serial communication
     
     display . begin () ; // start up the OLED display
     display . setFlipMode (0) ; // set to  or 0 , depending on orientation of board
     display.clearDisplay();
     
 }


void sendPotentiometerData() {
    //const auto value = (analogRead(A0))/10.23;

    const auto value = analogRead(A0);
    const byte data[] = {0, 0, highByte(value), lowByte(value)};
    
    Serial.write(data, 4);
    Serial.println();
    
    
    display.setFont(u8x8_font_profont29_2x3_r);
    display.setCursor(0, 0); 
    display.print("Volume:");
  
    display.setCursor(0, 5);
    display.print(String(value/10.23));

}

/* --------------- Run this over and over ------------------- */
void loop() {
    sendPotentiometerData();
    delay(500);
    
}
