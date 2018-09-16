package fmnavarretem.co.kannsyndrome.View

import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom

interface IEvaluatorView {
    fun notifyEvaluationDone(symptom: Symptom)
    fun notifyBadAge()
}