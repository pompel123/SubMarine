package de.simon.dankelmann.submarine.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import de.simon.dankelmann.submarine.Entities.SignalEntity
import de.simon.dankelmann.submarine.Models.SignalGeneratorDataModel
import de.simon.dankelmann.submarine.ui.SignalGenerator.TabFragments.BinaryTab.BinaryTabFragment
import de.simon.dankelmann.submarine.ui.SignalGenerator.TabFragments.ConfigTab.ConfigTabFragment
import de.simon.dankelmann.submarine.ui.SignalGenerator.TabFragments.HexTab.HexTabFragment
import de.simon.dankelmann.submarine.ui.SignalGenerator.TabFragments.TimingsTab.TimingsTabFragment
import de.simon.dankelmann.submarine.ui.ViewSignalEntity.SignalMapTab.SignalMapTabFragment
import de.simon.dankelmann.submarine.ui.ViewSignalEntity.TabFragments.SignalDataTab.SignalDataTabFragment

class SignalGeneratorTabCollectionAdapter (fragment: Fragment, signalGeneratorDataModel: SignalGeneratorDataModel) : FragmentStateAdapter(fragment) {

    private lateinit var _signalGeneratorDataModel:SignalGeneratorDataModel

    private lateinit var _timingsTabFragment:TimingsTabFragment
    private lateinit var _binaryTabFragment:BinaryTabFragment
    private lateinit var _hexTabFragment:HexTabFragment
    private lateinit var _configTabFragment:ConfigTabFragment

    init{
        _signalGeneratorDataModel = signalGeneratorDataModel

        _timingsTabFragment = TimingsTabFragment(_signalGeneratorDataModel)
        _binaryTabFragment = BinaryTabFragment(_signalGeneratorDataModel)
        _hexTabFragment = HexTabFragment(_signalGeneratorDataModel)
        _configTabFragment = ConfigTabFragment(_signalGeneratorDataModel)
    }

    fun updateSignalGeneratorDataModel(signalGeneratorDataModel: SignalGeneratorDataModel){
        _signalGeneratorDataModel = signalGeneratorDataModel
        _timingsTabFragment.updateSignalGeneratorDataModel(_signalGeneratorDataModel)
        _binaryTabFragment.updateSignalGeneratorDataModel(_signalGeneratorDataModel)
        _hexTabFragment.updateSignalGeneratorDataModel(_signalGeneratorDataModel)
        _configTabFragment.updateSignalGeneratorDataModel(_signalGeneratorDataModel)
    }

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return _timingsTabFragment
            1 -> return _binaryTabFragment
            2 -> return _hexTabFragment
            3 -> return _configTabFragment
        }
        return _timingsTabFragment
    }


}