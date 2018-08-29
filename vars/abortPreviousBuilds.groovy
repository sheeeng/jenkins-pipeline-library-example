import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    currentBuild.getCauses().each {
        if (cause instanceof Cause.UserIdCause) {
            echo "Cause.UserIdCause"
        }
        if (cause instanceof Cause.RemoteCause) {
            echo "Cause.RemoteCause"
        }
        if (cause instanceof Cause.UpstreamCause) {
            echo "Cause.UpstreamCause"
        }
    }
    // https://stackoverflow.com/a/49901413/4763512
    Run previousBuild = currentBuild.rawBuild.getPreviousBuildInProgress()
    while (previousBuild != null) {
        if (previousBuild.isInProgress()) {
            def executor = previousBuild.getExecutor()
            if (executor != null) {
                echo ">> Aborting older build #${previousBuild.number}."
                executor.interrupt(Result.ABORTED, new UserInterruption(
                    "Aborted by newer build #${currentBuild.number}."
                ))
            }
        }
        previousBuild = previousBuild.getPreviousBuildInProgress()
    }
}
