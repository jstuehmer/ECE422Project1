#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "InsertionSort.h"

/*
 * Created on March 5, 2017
 * @author: Stuehmer
 */

JNIEXPORT jintArray JNICALL Java_InsertionSort_insertsort
(JNIEnv *env, jobject object, jintArray values) {

    jsize len;
    jint temp, *a;
    int i, j;
    jintArray result;
    jboolean *is_copy = 0;

    jclass class = (*env)->GetObjectClass(env, object);
    jfieldID fidMemCount = (*env)->GetFieldID(env, class, "memCount", "I");
    if (fidMemCount == NULL) return;
    jint memCount = (*env)->GetIntField(env, object, fidMemCount);

    len = (*env)->GetArrayLength(env, values);
    jintArray aSorted = (*env)->NewIntArray(env, len);

    a = (jint *) (*env)->GetIntArrayElements(env, values, is_copy);
    if (a == NULL) {
        printf("Cannot obtain array from JVM\n");
        exit(0);
    }

    for (i = 1; i < len; i++) {
        temp = a[i];
        memCount += 6;
        for (j = i; j > 0 && a[j-1] > temp; j--) {
            a[j] = a[j-1];
            memCount += 10;
        }
        a[j] = temp;
        memCount += 3;
    }
    (*env)->SetIntField(env, object, fidMemCount, memCount);

    (*env)->SetIntArrayRegion(env, aSorted, 0, len, a);
    return aSorted;
}
