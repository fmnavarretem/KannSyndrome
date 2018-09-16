package fmnavarretem.co.kannsyndrome.Presenter

import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom

interface IEvaluatorPresenter {
    fun doEvaluation(symptom: Symptom)
}