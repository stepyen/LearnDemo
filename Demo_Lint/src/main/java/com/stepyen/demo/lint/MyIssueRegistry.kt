package com.stepyen.demo.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

/**
 * date：2021/1/18
 * author：stepyen
 * description：问题仓库
 *
 */
class MyIssueRegistry: IssueRegistry() {
    override val issues: List<Issue>
        get() = mutableListOf(
            OrientationTransparencyDetector.issue
        )

}