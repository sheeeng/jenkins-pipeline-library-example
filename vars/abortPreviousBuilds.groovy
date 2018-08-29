import hudson.model.Result
import hudson.model.Run
import jenkins.model.CauseOfInterruption.UserInterruption

def call() {
    def env = build.getEnvironment()
    def gitBranch = env['GIT_BRANCH']
    def gitCommit = env['GIT_COMMIT']
    def shortGitCommit = gitCommit[0..6]
    def gitPreviousCommit = env['GIT_PREVIOUS_COMMIT']
    def gitPreviousSuccessfulCommit = env['GIT_PREVIOUS_SUCCESSFUL_COMMIT']
    sh 'echo ${gitBranch}'
    sh 'echo ${gitCommit}'
    sh 'echo ${shortGitCommit}'
    sh 'echo ${gitPreviousCommit}'
    
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
