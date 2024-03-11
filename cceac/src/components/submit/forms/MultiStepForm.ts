import { ReactElement, useState } from "react"

export default function MultiStepForm(steps: ReactElement[]) {
    const [currentStep, setCurrentStep] = useState(0)

    function goToStep(step: number) {
        setCurrentStep(step)
    }

    function nextStep() {
        setCurrentStep(step => (step >= steps.length - 1) ? step : step + 1)
    }

    function prevStep() {
        setCurrentStep(step => (step <= 0) ? step : step - 1)
    }

    return {
        currentStep,
        currentStepComponent: steps[currentStep],
        isFirstStep: currentStep === 0,
        isLastStep: currentStep === steps.length - 1,
        steps,
        goToStep,
        nextStep,
        prevStep
    }
}