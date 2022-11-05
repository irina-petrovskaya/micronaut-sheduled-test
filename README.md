## Micronaut: false-positive 'unsatisfied dependency' error on injecting io.micronaut.scheduling.TaskScheduler

[https://youtrack.jetbrains.com/issue/IDEA-305383](https://youtrack.jetbrains.com/issue/IDEA-305383)

TaskScheduler injecting is falsely reported as unsatisfied dependency.
The error goes away after the ``@Named`` annotation removing

The project bean with the same annotations as the injected io.micronaut.scheduling.ScheduledExecutorTaskScheduler
(``@Singleton``, ``@Primary``, ``@Named(SOME_CONSTANT_REFERENCE)`` doesn't cause the error
