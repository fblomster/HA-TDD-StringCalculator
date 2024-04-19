public class LoggerStub implements Logger {
    @Override
    public void log(int integer) {
        System.out.println("Logged number: " + integer);
    }
}