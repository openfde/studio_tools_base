/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.lint.checks

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Incident
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.XmlScanner
import com.android.tools.lint.detector.api.Severity
import com.android.SdkConstants.TAG_ACTIVITY_ALIAS
import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Element

/** Lint check to ban specific attributes on <activity-alias> that have no effect. */
class RedundantActivityAliasAttributesDetector : Detector(), XmlScanner {

    override fun getApplicableElements(): List<String> {
        return listOf(TAG_ACTIVITY_ALIAS)
    }

    override fun visitElement( context : XmlContext, element : Element) {
      val targetActivity = element.getAttributeNodeNS(ANDROID_NAMESPACE, "targetActivity")?.value ?: return
      val attributes = element.attributes ?: return

      for (i in 0 until attributes.length) {
        val attr = attributes.item(i)
        if (attr.namespaceURI == ANDROID_NAMESPACE) {
          val attributeName = attr.localName ?: attr.nodeName
          if (attributeName !in allowedAttributes) {
            context.report(
              Incident(ISSUE, element, context.getNameLocation(element),
                "Attribute '$attributeName' defined for <activity-alias>" +
                " targeting '$targetActivity' has no effect and should be removed. This value is not used by the alias.",
              )
            )
          }
        }
      }
    }

  companion object {

    @JvmField
    val ISSUE = Issue.create(
        id = "RedundantActivityAliasAttributesDetector",
        briefDescription = "Only a specific subset of <activity> attributes can be overridden by <activity-alias>; no attributes outside the subset should be defined as they do not have any effect.",
        category = Category.CORRECTNESS,
        severity = Severity.WARNING,
        androidSpecific = true,
        implementation = Implementation(
            RedundantActivityAliasAttributesDetector::class.java, Scope.MANIFEST,
        )
    )

    private val ANDROID_NAMESPACE = "http://schemas.android.com/apk/res/android"

    // Attributes that are allowed to be defined on <activity-alias> under the android namespace
    // based on
    // https://osscs.corp.google.com/android/platform/superproject/main/+/main:frameworks/base/core/java/com/android/internal/pm/pkg/component/ParsedActivityUtils.java;l=302;drc=c5c6c1a7ca1c73eed444cfcd1511d5fe2244fdbb
    private val allowedAttributes =
      setOf(
        "enabled",
        "exported",
        "icon",
        "label",
        "name",
        "permission",
        "parentActivityName",
        "attributionTags",
        "banner",
        "description",
        "logo",
        "roundIcon",
        "targetActivity",
      )
  }
}