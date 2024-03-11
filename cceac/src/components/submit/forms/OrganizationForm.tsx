type OrganizationData = {
    organizations: string
}

const InitialData: OrganizationData = {
    organizations: "",
}

type OrganizationFormProps = OrganizationData & {
    updateFields: (fields: Partial<OrganizationData>) => void
}

export default function OrganizationForm({
    organizations,
    updateFields
}: OrganizationFormProps) {
    return (
        <div>
            
        </div>
    )
}