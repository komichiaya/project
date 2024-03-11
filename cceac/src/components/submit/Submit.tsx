import axios, { AxiosResponse } from "axios"
import React, { FormEvent, useEffect, useState } from "react"
import ContributorForm from "./forms/ContributorForm"
import CountryForm from "./forms/CountryForm"
import IndustryForm from "./forms/IndustryForm"
import LanguageForm from "./forms/LanguageForm"
import MultiStepForm from "./forms/MultiStepForm"
import OrganizationForm from "./forms/OrganizationForm"
import ProgressBar from "./progress/ProgressBar"
import SubmitForm from "./forms/SubmitForm"
import ThemeForm from "./forms/ThemeForm"
import ToolForm from "./forms/ToolForm"
import TypeForm from "./forms/TypeForm"

type SubmitData = {
    contributor: string
    title: string
    email: string

    description: string
    source: string
    URL: string
    toolFile: File | null
    thumbnail: File | null
    imgFile: File | null
    type: string
    industry: string
    themes: string
    organizations: string
    country: string[]
    region: string
    language: string[]
    // create_time: Date
    // is_review: number
}

const InitialData: SubmitData = {
    title: "Student",
    description: "This is a test description for the submission page",
    contributor: "Mohamed Farah",
    email: "fara0263@algonquinlive.com",
    source: "Myself",
    URL: "localhost",
    toolFile: null,
    imgFile: null,
    thumbnail: null,
    industry: "Test industry",
    themes: "all",
    organizations: "Test organization",
    country: ["Canada", "United States of America"],
    region: "North America",
    language: ["English", "French"],
    type: "Tools",
    // create_time: new Date(),
    // is_review: 0
}

const Submit: React.FC = () => {
    useEffect(() => {
        document.title = "Toolbox - Submit | CCEAC"
    })

    const [data, setData] = useState(InitialData)
    const [finalStepReached, setFinalStepReached] = useState(false)

    function updateFields(fields: Partial<SubmitData>) {
        setData(previousState => {
            return { ...previousState, ...fields }
        })
    }

    const {
        currentStep,
        currentStepComponent,
        isFirstStep,
        isLastStep,
        steps,
        goToStep,
        nextStep,
        prevStep
    } = MultiStepForm([
        <ContributorForm {...data} updateFields={updateFields} />,
        <ToolForm {...data} updateFields={updateFields} />,
        <TypeForm {...data} updateFields={updateFields} />,
        <IndustryForm {...data} updateFields={updateFields} />,
        <ThemeForm {...data} updateFields={updateFields} />,
        <OrganizationForm {...data} updateFields={updateFields} />,
        <CountryForm {...data} updateFields={updateFields} />,
        <LanguageForm {...data} updateFields={updateFields} />,
        <SubmitForm {...data} />
    ])

    async function onSubmit(e: FormEvent) {
        e.preventDefault()

        if (currentStep === steps.length - 2) {
            setFinalStepReached(true)
        }

        if (!isLastStep) {
            return nextStep()
        }

        try {
            const jsonData = JSON.stringify(data)
            console.log(data)
            const jsonData1 = {
                "contributor": "string",
                "country": "string",
                "description": "string",
                "email": "string",
                "industry": "string",
                "language": "string",
                "organizations": "string",
                "region": "string",
                "source": "string",
                "themes": "string",
                "thumbnail": "string",
                "title": "string",
                "toolFile": "string",
                "type": "string",
                "url": "string"
            }
            const data1 = new URLSearchParams(data)

            const response = await axios.post("/api/user/submit", data1)

            console.log("Sucess: ", response.data)
            alert("Success!")
        } catch (error) {
            console.error("Failure: ", error)
            // alert("Failure..."+result)
        }
    }

    function returnToSubmit() {
        goToStep(steps.length - 1)
    }

    return (
        <div className="submit">
            <ProgressBar currentStep={currentStep} goToStep={goToStep} />
            {currentStepComponent}

            <form onSubmit={onSubmit}>
                <div className="contribute">
                    {isFirstStep ? null : (
                        <button type="button" onClick={prevStep}>Previous Page</button>
                    )}

                    <button type="submit">{isLastStep ? "Submit" : "Next Page"}</button>
                </div>

                {isLastStep || !finalStepReached ? null : (
                    <div className="contribute">
                        <button type="button" onClick={returnToSubmit}>Return to Submit</button>
                    </div>
                )}
            </form>

            {currentStep !== 1 ? null : (
                <div className="tutorial">
                    <h1>If you don't know how to screen capture an image with the Windows Snipping Tool to submit as a thumbnail image, check out this short explainer video to learn how.</h1>

                    <video controls>
                        <source src="./src/assets/videos/ScreenCapture.mp4" />
                    </video>
                </div>
            )}
        </div>
    )
}

export default Submit