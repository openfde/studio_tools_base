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

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Detector

class RedundantActivityAliasAttributesDetectorTest : AbstractCheckTest() {
  override fun getDetector(): Detector {
    return RedundantActivityAliasAttributesDetector()
  }

  private val activityAliasWithRedundantAttributesXmlExample: TestFile =
    xml(
        """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
            package="com.google.apps.tiktok.conformance.lint.checks.inputs">
          <application>
            <!-- BUG: Diagnostic contains: Attribute 'process' defined for <activity-alias> targeting 'com.google.android.apps.test.TestActivity' has no effect and should be removed. This value is not used by the alias.-->
            <activity-alias
                android:name="com.google.android.apps.test.TestActivityAlias"
                android:targetActivity="com.google.android.apps.test.TestActivity"
                android:process=":testProcess"
                android:label="@string/test_activity_name"
                android:exported="true"
                android:icon="@drawable/test_icon"
                android:attributionTags="testing_alias"
                android:permission="test.permission.TESTING_PERMISSION"
                android:banner="@string/test_banner"
                android:description="@string/test_description"
                android:logo="@drawable/test_logo"
                android:roundIcon="@drawable/test_round_icon"
                >
              <intent-filter>
                  <action android:name="test.action.TEST_ACTION" />
                  <category android:name="test.category.TEST_CATEGORY" />
              </intent-filter>
            </activity-alias>
            <!-- BUG: Diagnostic contains: Attribute 'theme' defined for <activity-alias> targeting 'com.google.android.apps.test.TestActivity' has no effect and should be removed. This value is not used by the alias.-->
            <activity-alias
                android:name="com.google.android.apps.test.TestActivityAlias2"
                android:targetActivity="com.google.android.apps.test.TestActivity"
                android:permission="test.permission.TESTING_PERMISSION"
                android:theme="@style/Theme.Test.NoDisplay"
                >
            </activity-alias>
            <!-- BUG: Diagnostic contains: Attribute 'visibleToInstantApps' defined for <activity-alias> targeting 'com.google.android.apps.test.TestActivity' has no effect and should be removed. This value is not used by the alias.-->
            <activity-alias
                android:name="com.google.android.apps.test.TestActivityAlias3"
                android:targetActivity="com.google.android.apps.test.TestActivity"
                android:visibleToInstantApps="true"
                android:permission="test.permission.TESTING_PERMISSION"
                android:theme="@style/Theme.Test.NoDisplay"
                >
            </activity-alias>
          </application>
        </manifest>
        """
      )
      .indented()


  fun testComprehensiveExamples() {
    lint()
      .files(
        activityAliasWithRedundantAttributesXmlExample,
      )
      .run()
      // add after running the test
      .expect(
        """
        """
      )
  }
}
