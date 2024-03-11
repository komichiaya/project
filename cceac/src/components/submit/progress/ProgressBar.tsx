import classNames from "classnames"
import { useState } from "react"

type ProgressData = {
    currentStep: number
    goToStep: (step: number) => void
}

export default function ProgressBar({
    currentStep,
    goToStep
}: ProgressData): JSX.Element {
    const [farthestStepReached, setFarthestStepReached] = useState(0)

    if (farthestStepReached < currentStep) {
        setFarthestStepReached(currentStep)
    }

    const progressBarLabels = [
        "Contributor",
        "Tool",
        "Type",
        "Industry",
        "Theme",
        "Organization",
        "Country",
        "Language",
        "Submit"
    ]

    const labelClassNames = progressBarLabels.map((_, index) => {
        return classNames("label", {
            bookmark: currentStep < index && index === farthestStepReached,
            future: currentStep < index && index > farthestStepReached,
            past: currentStep > index || currentStep < index && index < farthestStepReached,
            present: currentStep === index
        })
    })

    return (
        <div className="progress">
            {progressBarLabels.map((label, index) => (
                <div
                    key={index}
                    className={labelClassNames[index]}
                    onClick={() => goToStep(index)}>

                    {label}
                </div>
            ))}
        </div>
    )
}