// State interface
interface ProcessState {
    void start(ProcessContext context);
    void suspend(ProcessContext context);
    void terminate(ProcessContext context);
}

// Concrete State: New
class NewState implements ProcessState {
    @Override
    public void start(ProcessContext context) {
        System.out.println("Process is now ready.");
        context.setState(new ReadyState());
    }

    @Override
    public void suspend(ProcessContext context) {
        System.out.println("Cannot suspend. Process is not started yet.");
    }

    @Override
    public void terminate(ProcessContext context) {
        System.out.println("Terminating process.");
        context.setState(new TerminatedState());
    }
}

// Concrete State: Ready
class ReadyState implements ProcessState {
    @Override
    public void start(ProcessContext context) {
        System.out.println("Process is now running.");
        context.setState(new RunningState());
    }

    @Override
    public void suspend(ProcessContext context) {
        System.out.println("Process is already ready and can be suspended.");
        context.setState(new NewState());
    }

    @Override
    public void terminate(ProcessContext context) {
        System.out.println("Terminating process.");
        context.setState(new TerminatedState());
    }
}

// Concrete State: Running
class RunningState implements ProcessState {
    @Override
    public void start(ProcessContext context) {
        System.out.println("Process is already running.");
    }

    @Override
    public void suspend(ProcessContext context) {
        System.out.println("Suspending the process. It is now ready.");
        context.setState(new ReadyState());
    }

    @Override
    public void terminate(ProcessContext context) {
        System.out.println("Terminating process.");
        context.setState(new TerminatedState());
    }
}

// Concrete State: Terminated
class TerminatedState implements ProcessState {
    @Override
    public void start(ProcessContext context) {
        System.out.println("Process is terminated and cannot be started again.");
    }

    @Override
    public void suspend(ProcessContext context) {
        System.out.println("Process is terminated and cannot be suspended.");
    }

    @Override
    public void terminate(ProcessContext context) {
        System.out.println("Process is already terminated.");
    }
}

// Context class
class ProcessContext {
    private ProcessState currentState;

    public ProcessContext() {
        currentState = new NewState(); // Default state
    }

    public void setState(ProcessState state) {
        currentState = state;
    }

    public void startProcess() {
        currentState.start(this);
    }

    public void suspendProcess() {
        currentState.suspend(this);
    }

    public void terminateProcess() {
        currentState.terminate(this);
    }
}

// Main class to test the State Design Pattern
public class StatePatternExample {
    public static void main(String[] args) {
        ProcessContext process = new ProcessContext();

        process.startProcess();    // Transition from New -> Ready
        process.startProcess();    // Transition from Ready -> Running
        process.suspendProcess();  // Transition from Running -> Ready
        process.terminateProcess(); // Transition to Terminated

        process.startProcess();    // Will not work because the process is terminated
    }
}
