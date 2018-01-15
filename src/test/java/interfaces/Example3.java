package interfaces;

@SuppressWarnings("unused")
interface First {

    int value = 100;

//    int getValueFromFirst();

    int getValue();

//    default int getValue() {
//        return value;
//    }
}

@SuppressWarnings("unused")
interface Second {

    int value = -100;

//    int getValueFromSecond();

//    int getValue();

//    default int getValue() {
//        return value;
//    }
}

