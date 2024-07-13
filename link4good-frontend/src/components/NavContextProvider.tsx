import {
  createContext,
  useContext,
  useState,
  type ReactNode,
  type Dispatch,
  type SetStateAction,
} from 'react'

// Step 1: Define the Context
interface NavContextType {
  isDrawerOpen: boolean
  setIsDrawerOpen: Dispatch<SetStateAction<boolean>>
}

const NavContext = createContext<NavContextType | undefined>(undefined)

// Step 2: Create the Provider Component
interface NavProviderProps {
  children: ReactNode
}

const NavProvider: React.FC<NavProviderProps> = ({ children }) => {
  const [isDrawerOpen, setIsDrawerOpen] = useState<boolean>(false)

  return (
    <NavContext.Provider value={{ isDrawerOpen, setIsDrawerOpen }}>
      {children}
    </NavContext.Provider>
  )
}

// Step 3: Create a Custom Hook
const useNav = (): NavContextType => {
  const context = useContext(NavContext)
  if (!context) {
    throw new Error('useNav must be used within a NavProvider')
  }
  return context
}

// Export the provider and the custom hook
export { NavProvider, useNav }
