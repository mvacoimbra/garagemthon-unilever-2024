// @ts-nocheck
import { randCompanyName, randNumber } from '@ngneat/falso'
import ProductTable from './ProductTable'

export type ListItemProps = {
  index: number
}

const Status = (props) => {
  const rand = props.rand

  const randStatus = () => {
    switch (true) {
      case rand === 0:
        return (
          <div className="tooltip hover:tooltip-open" data-tip="Pendente">
            <div className="h-5 w-5 bg-warning rounded-full" />
          </div>
        )
      case rand === 1:
        return (
          <div className="tooltip hover:tooltip-open" data-tip="Aprovada">
            <div className="h-5 w-5 bg-success rounded-full" />
          </div>
        )
      case rand === 2:
        return (
          <div className="tooltip hover:tooltip-open" data-tip="Rejeitada  ">
            <div className="h-5 w-5 bg-error rounded-full" />
          </div>
        )
    }
  }
  return randStatus()
}

export default function ListItem({ index }: ListItemProps) {
  const rand = randNumber({ min: 0, max: 2 })
  const even = index % 2 === 0
  return (
    <div className="collapse collapse-arrow bg-slate-300">
      <input type="radio" name="my-accordion-2" defaultChecked />
      <div className="collapse-title text-xl font-medium">
        <div className="flex-row">
          <Status rand={rand} />
          <div className="flex flex-row gap-2">
            <span className="font-semibold">Id:</span>
            <span>{String(index + 1).padStart(3, '0')}</span>
          </div>
          <div className="flex flex-row gap-2">
            <span className="font-semibold">Solicitante:</span>
            <span>{randCompanyName({ length: 1 })}</span>
          </div>
          <div className="flex flex-row gap-2">
            <span className="font-semibold">Transportadora:</span>
            <span>{rand === 1 ? randCompanyName({ length: 1 }) : '-'}</span>
          </div>
        </div>
      </div>
      <div className="collapse-content">
        <ProductTable />
      </div>
    </div>
  )
}

/* <li>
<div
  className={`collapse collapse-plus w-full ${even ? 'bg-neutral-200' : 'bg-neutral-100'}`}
>
  <input type="radio" name="my-accordion-3" />
  <div className="collapse-title text-lg max-sm:text-base font-medium flex flex-row flex-wrap items-center justify-start gap-5">
    <Status rand={rand} />
    <div className="flex flex-row gap-2">
      <span className="font-semibold">Id:</span>
      <span>{String(index + 1).padStart(3, '0')}</span>
    </div>
    <div className="flex flex-row gap-2">
      <span className="font-semibold">Solicitante:</span>
      <span>{randCompanyName({ length: 1 })}</span>
    </div>
    <div className="flex flex-row gap-2">
      <span className="font-semibold">Transportadora:</span>
      <span>{rand === 1 ? randCompanyName({ length: 1 }) : '-'}</span>
    </div>
  </div>
  <div className="collapse-content">
    <div className="min-w-96">
      <ProductTable />
    </div>
  </div>
</div>
</li> */
