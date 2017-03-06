#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "InsertionSort.h"

JNIEXPORT jintArray JNICALL Java_InsertionSort_insertsort
(JNIEnv *env, jobject object, jintArray values) {

    jsize len;
    jint temp, *a, *memCount;
    int i, j;
    jintArray result;
    jboolean *is_copy = 0;

    len = (*env)->GetArrayLength(env, values);
    jintArray aSorted = (*env)->NewIntArray(env, len);

    a = (jint *) (*env)->GetIntArrayElements(env, values, is_copy);
    if (a == NULL) {
        printf("Cannot obtain array from JVM\n");
        exit(0);
    }

    for (i = 1; i < len; i++) {
        temp = a[i];
        for (j = i; j > 0 && a[j-1] > temp; j--) {
            a[j] = a[j-1];
        }
        a[j] = temp;
    }

    (*env)->SetIntArrayRegion(env, aSorted, 0, len, a);
    return aSorted;
}
