package fmnavarretem.co.kannsyndrome.Model

import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom

interface IEvaluatorBL {
    fun doEvaluation(symptom: Symptom)
}