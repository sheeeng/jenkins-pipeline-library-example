import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    // https://stackoverflow.com/a/49901413/4763512
    Run currentBuild = currentBuild.rawBuild
    List<Cause> causes = currentBuild.getCauses()
    if (causes==null)
        echo ">> Empty causes!"
    else
        echo ">> Got causes!"

    for (Cause cause : causes) {
        if (cause instanceof Cause.UserIdCause) {
            println ">> Cause.UserIdCause"
            println ">> " currentBuild.rawBuild.getCause(hudson.model.Cause$UserIdCause)
        }
        else if (cause instanceof Cause.RemoteCause) {
            println ">> Cause.RemoteCause"
        }
        else if (cause instanceof Cause.UpstreamCause) {
            println ">> Cause.UpstreamCause"
        }
        else {
            println ">> Unknown causes!"
        }
    }
}
