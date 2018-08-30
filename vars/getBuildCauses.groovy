import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    // https://stackoverflow.com/a/49901413/4763512
    Run currentBuild = currentBuild.rawBuild

    // https://javadoc.jenkins.io/hudson/model/Cause.html
    List<Cause> causes = currentBuild.getCauses()


    if (causes==null)
        echo ">> Empty causes!"
    else
        echo ">> Got causes!"

    for (Cause cause : causes) {
        if (cause instanceof Cause.UserIdCause) {
            println ">> Cause.UserIdCause"
            // https://javadoc.jenkins-ci.org/hudson/model/Cause.UserIdCause.html
            println cause.getShortDescription()
            println cause.getUserId()
            println cause.getUserName()
            println cause.getUserUrl()
        }
        else if (cause instanceof Cause.RemoteCause) {
            println ">> Cause.RemoteCause"
            // https://javadoc.jenkins-ci.org/hudson/model/Cause.RemoteCause.html
            println cause.getAddr()
            println cause.getNote()
            println cause.getShortDescription()
        }
        else if (cause instanceof Cause.UpstreamCause) {
            println ">> Cause.UpstreamCause"
            // https://javadoc.jenkins-ci.org/hudson/model/Cause.UpstreamCause.html
            println	getShortDescription()
            println getUpstreamBuild()
            println getUpstreamCauses().size()
            println getUpstreamProject()
            println getUpstreamRun().getUrl()
            println getUpstreamUrl()
        }
        else {
            println ">> Unknown causes!"
        }
    }
}
