package fmnavarretem.co.kannsyndrome.Presenter

import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom

interface IEvaluatorListener {
    fun onEvaluationDone(symptom: Symptom)
    fun onBadAge()
}