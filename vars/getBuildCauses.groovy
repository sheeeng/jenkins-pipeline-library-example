import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    // https://stackoverflow.com/a/49901413/4763512
    Run currentBuild = currentBuild.rawBuild
    currentBuild.getCauses().each {
        if (cause instanceof Cause.UserIdCause) {
            echo ">> Cause.UserIdCause"
        }
        if (cause instanceof Cause.RemoteCause) {
            echo ">> Cause.RemoteCause"
        }
        if (cause instanceof Cause.UpstreamCause) {
            echo ">> Cause.UpstreamCause"
        }
    }
}
